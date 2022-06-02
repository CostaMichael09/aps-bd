<template>
  <div>
    <h2 id="page-heading" data-cy="MedicoHeading">
      <span id="medico-heading">Medicos</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Atualizar</span>
        </button>
        <router-link :to="{ name: 'MedicoCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-medico"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span> Cire um novo medico </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && medicos && medicos.length === 0">
      <span>Não foi encontrado nenhum medico</span>
    </div>
    <div class="table-responsive" v-if="medicos && medicos.length > 0">
      <table class="table table-striped" aria-describedby="medicos">
        <thead>
          <tr>
<!--            <th scope="row" v-on:click="changeOrder('id')">-->
<!--              <span>ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>-->
<!--            </th>-->
            <th scope="row" v-on:click="changeOrder('nome')">
              <span>Nome</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nome'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('especialidade')">
              <span>Especialidade</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'especialidade'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('crm')">
              <span>Crm</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'crm'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="medico in medicos" :key="medico.id" data-cy="entityTable">
<!--            <td>-->
<!--              <router-link :to="{ name: 'MedicoView', params: { medicoId: medico.id } }">{{ medico.id }}</router-link>-->
<!--            </td>-->
            <td>{{ medico.nome }}</td>
            <td>{{ medico.especialidade }}</td>
            <td>{{ medico.crm }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'MedicoView', params: { medicoId: medico.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">Detalhes</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'MedicoEdit', params: { medicoId: medico.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Editar</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(medico)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline">Deletar</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="apsbdApp.medico.delete.question" data-cy="medicoDeleteDialogHeading">Confirmar</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-medico-heading">Tem certeza que deseja apagar esse Medico?</p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-medico"
          data-cy="entityConfirmDeleteButton"
          v-on:click="removeMedico()"
        >
          Deletar
        </button>
      </div>
    </b-modal>
    <div v-show="medicos && medicos.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./medico.component.ts"></script>
