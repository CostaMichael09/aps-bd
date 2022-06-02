<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="medico">
        <h2 class="jh-entity-heading" data-cy="medicoDetailsHeading"><span>Medico</span> {{ medico.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Nome</span>
          </dt>
          <dd>
            <span>{{ medico.nome }}</span>
          </dd>
          <dt>
            <span>Especialidade</span>
          </dt>
          <dd>
            <span>{{ medico.especialidade }}</span>
          </dd>
          <dt>
            <span>Crm</span>
          </dt>
          <dd>
            <span>{{ medico.crm }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span> Voltar</span>
        </button>
        <router-link v-if="medico.id" :to="{ name: 'MedicoEdit', params: { medicoId: medico.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span> Editar</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./medico-details.component.ts"></script>
