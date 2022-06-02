import { Component, Vue, Inject } from 'vue-property-decorator';

import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import MedicoService from '@/entities/medico/medico.service';
import { IMedico } from '@/shared/model/medico.model';

import PacienteService from '@/entities/paciente/paciente.service';
import { IPaciente } from '@/shared/model/paciente.model';

import { IExame, Exame } from '@/shared/model/exame.model';
import ExameService from './exame.service';

const validations: any = {
  exame: {
    tipo: {},
    data: {},
    nomedomedico: {},
  },
};

@Component({
  validations,
})
export default class ExameUpdate extends Vue {
  @Inject('exameService') private exameService: () => ExameService;
  @Inject('alertService') private alertService: () => AlertService;

  public exame: IExame = new Exame();

  @Inject('medicoService') private medicoService: () => MedicoService;

  public medicos: IMedico[] = [];

  @Inject('pacienteService') private pacienteService: () => PacienteService;

  public pacientes: IPaciente[] = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.exameId) {
        vm.retrieveExame(to.params.exameId);
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
    if (this.exame.id) {
      this.exameService()
        .update(this.exame)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Exame is updated with identifier ' + param.id;
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
      this.exameService()
        .create(this.exame)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = 'A Exame is created with identifier ' + param.id;
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

  public convertDateTimeFromServer(date: Date): string {
    if (date && dayjs(date).isValid()) {
      return dayjs(date).format(DATE_TIME_LONG_FORMAT);
    }
    return null;
  }

  public updateInstantField(field, event) {
    if (event.target.value) {
      this.exame[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.exame[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.exame[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.exame[field] = null;
    }
  }

  public retrieveExame(exameId): void {
    this.exameService()
      .find(exameId)
      .then(res => {
        res.data = new Date(res.data);
        this.exame = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.medicoService()
      .retrieve()
      .then(res => {
        this.medicos = res.data;
      });
    this.pacienteService()
      .retrieve()
      .then(res => {
        this.pacientes = res.data;
      });
  }
}
