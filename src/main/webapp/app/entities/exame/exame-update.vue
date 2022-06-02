<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2 id="apsbdApp.exame.home.createOrEditLabel" data-cy="ExameCreateUpdateHeading">Criar ou editar Exame</h2>
        <div>
          <div class="form-group" v-if="exame.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="exame.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="exame-tipo">Tipo</label>
            <input
              type="text"
              class="form-control"
              name="tipo"
              id="exame-tipo"
              data-cy="tipo"
              :class="{ valid: !$v.exame.tipo.$invalid, invalid: $v.exame.tipo.$invalid }"
              v-model="$v.exame.tipo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="exame-data">Data</label>
            <div class="d-flex">
              <input
                id="exame-data"
                data-cy="data"
                type="datetime-local"
                class="form-control"
                name="data"
                :class="{ valid: !$v.exame.data.$invalid, invalid: $v.exame.data.$invalid }"
                :value="convertDateTimeFromServer($v.exame.data.$model)"
                @change="updateInstantField('data', $event)"
              />
            </div>
          </div>
<!--          <div class="form-group">-->
<!--            <label class="form-control-label" for="exame-nomedomedico">Nomedomedico</label>-->
<!--            <input-->
<!--              type="text"-->
<!--              class="form-control"-->
<!--              name="nomedomedico"-->
<!--              id="exame-nomedomedico"-->
<!--              data-cy="nomedomedico"-->
<!--              :class="{ valid: !$v.exame.nomedomedico.$invalid, invalid: $v.exame.nomedomedico.$invalid }"-->
<!--              v-model="$v.exame.nomedomedico.$model"-->
<!--            />-->
<!--          </div>-->
          <div class="form-group">
            <label class="form-control-label" for="exame-medico">Medico</label>
            <select class="form-control" id="exame-medico" data-cy="medico" name="medico" v-model="exame.medico">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="exame.medico && medicoOption.id === exame.medico.id ? exame.medico : medicoOption"
                v-for="medicoOption in medicos"
                :key="medicoOption.id"
              >
                {{ medicoOption.nome }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="exame-paciente">Paciente</label>
            <select class="form-control" id="exame-paciente" data-cy="paciente" name="paciente" v-model="exame.paciente">
              <option v-bind:value="null"></option>
              <option
                v-bind:value="exame.paciente && pacienteOption.id === exame.paciente.id ? exame.paciente : pacienteOption"
                v-for="pacienteOption in pacientes"
                :key="pacienteOption.id"
              >
                {{ pacienteOption.nome }}
              </option>
            </select>
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
            :disabled="$v.exame.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span>Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./exame-update.component.ts"></script>
