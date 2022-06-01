import { Component, Provide, Vue } from 'vue-property-decorator';

import UserService from '@/entities/user/user.service';
import ExameService from './exame/exame.service';
import PacienteService from './paciente/paciente.service';
import MedicoService from './medico/medico.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

@Component
export default class Entities extends Vue {
  @Provide('userService') private userService = () => new UserService();
  @Provide('exameService') private exameService = () => new ExameService();
  @Provide('pacienteService') private pacienteService = () => new PacienteService();
  @Provide('medicoService') private medicoService = () => new MedicoService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
