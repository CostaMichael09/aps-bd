import { Component, Vue, Inject } from 'vue-property-decorator';

import { IExame } from '@/shared/model/exame.model';
import ExameService from './exame.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class ExameDetails extends Vue {
  @Inject('exameService') private exameService: () => ExameService;
  @Inject('alertService') private alertService: () => AlertService;

  public exame: IExame = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.exameId) {
        vm.retrieveExame(to.params.exameId);
      }
    });
  }

  public retrieveExame(exameId) {
    this.exameService()
      .find(exameId)
      .then(res => {
        this.exame = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
