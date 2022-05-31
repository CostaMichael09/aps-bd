<template>
  <div>
    <h2 id="page-heading" data-cy="ExameHeading">
      <span id="exame-heading">Exames</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Atualizar</span>
        </button>
        <router-link :to="{ name: 'ExameCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-exame"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span> Crie um novo exame </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && exames && exames.length === 0">
      <span>Não existe exame(s)</span>
    </div>
    <div class="table-responsive" v-if="exames && exames.length > 0">
      <table class="table table-striped" aria-describedby="exames">
        <thead>
          <tr>
<!--            <th scope="row" v-on:click="changeOrder('id')">-->
<!--              <span>ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>-->
<!--            </th>-->
            <th scope="row" v-on:click="changeOrder('tipo')">
              <span>Tipo</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tipo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('data')">
              <span>Data</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'data'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nomedomedico')">
              <span>Nomedomedico</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nomedomedico'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="exame in exames" :key="exame.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ExameView', params: { exameId: exame.id } }">{{ exame.id }}</router-link>
            </td>
            <td>{{ exame.tipo }}</td>
            <td>{{ exame.data | formatDate }}</td>
            <td>{{ exame.nomedomedico }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ExameView', params: { exameId: exame.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">Ver detalhes</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ExameEdit', params: { exameId: exame.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Editar</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(exame)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline">Excluir</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="apsbdApp.exame.delete.question" data-cy="exameDeleteDialogHeading">Confirm delete operation</span></span
      >
      <div class="modal-body">
        <p id="jhi-delete-exame-heading">Você tem certeza que deseja deletar esse exame?</p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-on:click="closeDialog()">Cancelar</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-exame"
          data-cy="entityConfirmDeleteButton"
          v-on:click="removeExame()"
        >
          Deletar
        </button>
      </div>
    </b-modal>
    <div v-show="exames && exames.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./exame.component.ts"></script>
