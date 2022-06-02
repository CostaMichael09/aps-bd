<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="exame">
        <h2 class="jh-entity-heading" data-cy="exameDetailsHeading"><span>Exame</span> {{ exame.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Tipo</span>
          </dt>
          <dd>
            <span>{{ exame.tipo }}</span>
          </dd>
          <dt>
            <span>Data</span>
          </dt>
          <dd>
            <span>{{ exame.data | formatDate }}</span>
          </dd>
<!--          <dt>-->
<!--            <span>Nomedomedico</span>-->
<!--          </dt>-->
          <dd>
            <span>{{ exame.nomedomedico }}</span>
          </dd>
          <dt>
            <span>Medico</span>
          </dt>
          <dd>
            <div v-if="exame.medico">
              <router-link :to="{ name: 'MedicoView', params: { medicoId: exame.medico.id } }">{{ exame.medico.nome }}</router-link>
            </div>
          </dd>
          <dt>
            <span>Paciente</span>
          </dt>
          <dd>
            <div v-if="exame.paciente">
              <router-link :to="{ name: 'PacienteView', params: { pacienteId: exame.paciente.id } }">{{ exame.paciente.nome }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Voltar</span>
        </button>
        <router-link v-if="exame.id" :to="{ name: 'ExameEdit', params: { exameId: exame.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span> Editar</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./exame-details.component.ts"></script>
