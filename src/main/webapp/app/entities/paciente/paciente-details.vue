<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="paciente">
        <h2 class="jh-entity-heading" data-cy="pacienteDetailsHeading"><span>Paciente</span> {{ paciente.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Nome</span>
          </dt>
          <dd>
            <span>{{ paciente.nome }}</span>
          </dd>
          <dt>
            <span>Cpf</span>
          </dt>
          <dd>
            <span>{{ paciente.cpf }}</span>
          </dd>
          <dt>
            <span>Telefone</span>
          </dt>
          <dd>
            <span>{{ paciente.telefone }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Voltar</span>
        </button>
        <router-link v-if="paciente.id" :to="{ name: 'PacienteEdit', params: { pacienteId: paciente.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span> Editar</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./paciente-details.component.ts"></script>
