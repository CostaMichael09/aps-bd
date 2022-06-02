import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import ExameService from '@/entities/exame/exame.service';
import { IExame } from '@/shared/model/exame.model';

import { IMedico, Medico } from '@/shared/model/medico.model';
import MedicoService from './medico.service';

const validations: any = {
  medico: {
    nome: {},
    especialidade: {},
    crm: {},
  },
};

@Component({
  validations,
})
export default class MedicoUpdate extends Vue {
  @Inject('medicoService') private medicoService: () => MedicoService;
  @Inject('alertService') private alertService: () => AlertService;

  public medico: IMedico = new Medico();

  @Inject('exameService') private exameService: () => ExameService;

  public exames: IExame[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.medicoId) {
        vm.retrieveMedico(to.params.medicoId);
      }
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.medico.id) {
      this.medicoService()
        .update(this.medico)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Medico is updated with identifier ' + param.id;
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.medicoService()
        .create(this.medico)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Medico is created with identifier ' + param.id;
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public retrieveMedico(medicoId): void {
    this.medicoService()
      .find(medicoId)
      .then(res => {
        this.medico = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.exameService()
      .retrieve()
      .then(res => {
        this.exames = res.data;
      });
  }
}
