<template>
  <div>
    <h2 id="page-heading" data-cy="PacienteHeading">
      <span id="paciente-heading">Pacientes</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Atualizar</span>
        </button>
        <router-link :to="{ name: 'PacienteCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-paciente"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span> Criar novo paciente </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && pacientes && pacientes.length === 0">
      <span>Nao há nenhum paciente</span>
    </div>
    <div class="table-responsive" v-if="pacientes && pacientes.length > 0">
      <table class="table table-striped" aria-describedby="pacientes">
        <thead>
          <tr>
<!--            <th scope="row" v-on:click="changeOrder('id')">-->
<!--              <span>ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>-->
<!--            </th>-->
            <th scope="row" v-on:click="changeOrder('nome')">
              <span>Nome</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nome'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cpf')">
              <span>Cpf</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cpf'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('telefone')">
              <span>Telefone</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'telefone'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="paciente in pacientes" :key="paciente.id" data-cy="entityTable">
<!--            <td>-->
<!--              <router-link :to="{ name: 'PacienteView', params: { pacienteId: paciente.id } }">{{ paciente.id }}</router-link>-->
<!--            </td>-->
            <td>{{ paciente.nome }}</td>
            <td>{{ paciente.cpf }}</td>
            <td>{{ paciente.telefone }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'PacienteView', params: { pacienteId: paciente.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">Detalhes</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'PacienteEdit', params: { pacienteId: paciente.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Editar</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(paciente)"
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
        ><span id="apsbdApp.paciente.delete.question" data-cy="pacienteDeleteDialogHeading">Confirmar</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-paciente-heading">Tem certeza que deseja apagar esse Paciente?</p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-paciente"
          data-cy="entityConfirmDeleteButton"
          v-on:click="removePaciente()"
        >
          Deletar
        </button>
      </div>
    </b-modal>
    <div v-show="pacientes && pacientes.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./paciente.component.ts"></script>
