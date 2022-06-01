import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IPaciente, Paciente } from '@/shared/model/paciente.model';
import PacienteService from './paciente.service';

const validations: any = {
  paciente: {
    nome: {},
    cpf: {},
    telefone: {},
  },
};

@Component({
  validations,
})
export default class PacienteUpdate extends Vue {
  @Inject('pacienteService') private pacienteService: () => PacienteService;
  @Inject('alertService') private alertService: () => AlertService;

  public paciente: IPaciente = new Paciente();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pacienteId) {
        vm.retrievePaciente(to.params.pacienteId);
      }
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
    if (this.paciente.id) {
      this.pacienteService()
        .update(this.paciente)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Paciente is updated with identifier ' + param.id;
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
      this.pacienteService()
        .create(this.paciente)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Paciente is created with identifier ' + param.id;
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

  public retrievePaciente(pacienteId): void {
    this.pacienteService()
      .find(pacienteId)
      .then(res => {
        this.paciente = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
