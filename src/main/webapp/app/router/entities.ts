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
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
