import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

// prettier-ignore
const Exame = () => import('@/entities/exame/exame.vue');
// prettier-ignore
const ExameUpdate = () => import('@/entities/exame/exame-update.vue');
// prettier-ignore
const ExameDetails = () => import('@/entities/exame/exame-details.vue');
// prettier-ignore
const Paciente = () => import('@/entities/paciente/paciente.vue');
// prettier-ignore
const PacienteUpdate = () => import('@/entities/paciente/paciente-update.vue');
// prettier-ignore
const PacienteDetails = () => import('@/entities/paciente/paciente-details.vue');
// prettier-ignore
const Medico = () => import('@/entities/medico/medico.vue');
// prettier-ignore
const MedicoUpdate = () => import('@/entities/medico/medico-update.vue');
// prettier-ignore
const MedicoDetails = () => import('@/entities/medico/medico-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'exame',
      name: 'Exame',
      component: Exame,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'exame/new',
      name: 'ExameCreate',
      component: ExameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'exame/:exameId/edit',
      name: 'ExameEdit',
      component: ExameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'exame/:exameId/view',
      name: 'ExameView',
      component: ExameDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'paciente',
      name: 'Paciente',
      component: Paciente,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'paciente/new',
      name: 'PacienteCreate',
      component: PacienteUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'paciente/:pacienteId/edit',
      name: 'PacienteEdit',
      component: PacienteUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'paciente/:pacienteId/view',
      name: 'PacienteView',
      component: PacienteDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'medico',
      name: 'Medico',
      component: Medico,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'medico/new',
      name: 'MedicoCreate',
      component: MedicoUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'medico/:medicoId/edit',
      name: 'MedicoEdit',
      component: MedicoUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'medico/:medicoId/view',
      name: 'MedicoView',
      component: MedicoDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
