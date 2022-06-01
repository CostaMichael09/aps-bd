<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="apsbdApp.medico.home.createOrEditLabel" data-cy="MedicoCreateUpdateHeading">Create or edit a Medico</h2>
        <div>
          <div class="form-group" v-if="medico.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="medico.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="medico-nome">Nome</label>
            <input
              type="text"
              class="form-control"
              name="nome"
              id="medico-nome"
              data-cy="nome"
              :class="{ valid: !$v.medico.nome.$invalid, invalid: $v.medico.nome.$invalid }"
              v-model="$v.medico.nome.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="medico-especialidade">Especialidade</label>
            <input
              type="text"
              class="form-control"
              name="especialidade"
              id="medico-especialidade"
              data-cy="especialidade"
              :class="{ valid: !$v.medico.especialidade.$invalid, invalid: $v.medico.especialidade.$invalid }"
              v-model="$v.medico.especialidade.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="medico-crm">Crm</label>
            <input
              type="number"
              class="form-control"
              name="crm"
              id="medico-crm"
              data-cy="crm"
              :class="{ valid: !$v.medico.crm.$invalid, invalid: $v.medico.crm.$invalid }"
              v-model.number="$v.medico.crm.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span>Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.medico.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span>Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./medico-update.component.ts"></script>
