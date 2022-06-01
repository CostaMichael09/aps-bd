<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="apsbdApp.paciente.home.createOrEditLabel" data-cy="PacienteCreateUpdateHeading">Create or edit a Paciente</h2>
        <div>
          <div class="form-group" v-if="paciente.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="paciente.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="paciente-nome">Nome</label>
            <input
              type="text"
              class="form-control"
              name="nome"
              id="paciente-nome"
              data-cy="nome"
              :class="{ valid: !$v.paciente.nome.$invalid, invalid: $v.paciente.nome.$invalid }"
              v-model="$v.paciente.nome.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="paciente-cpf">Cpf</label>
            <input
              type="number"
              class="form-control"
              name="cpf"
              id="paciente-cpf"
              data-cy="cpf"
              :class="{ valid: !$v.paciente.cpf.$invalid, invalid: $v.paciente.cpf.$invalid }"
              v-model.number="$v.paciente.cpf.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="paciente-telefone">Telefone</label>
            <input
              type="text"
              class="form-control"
              name="telefone"
              id="paciente-telefone"
              data-cy="telefone"
              :class="{ valid: !$v.paciente.telefone.$invalid, invalid: $v.paciente.telefone.$invalid }"
              v-model="$v.paciente.telefone.$model"
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
            :disabled="$v.paciente.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span>Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./paciente-update.component.ts"></script>
