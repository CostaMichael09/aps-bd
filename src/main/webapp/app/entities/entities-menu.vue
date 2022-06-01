<template>
  <div>
    <b-dropdown-item to="/exame">
      <font-awesome-icon icon="asterisk" />
      <span>Exame</span>
    </b-dropdown-item>
    <b-dropdown-item to="/paciente">
      <font-awesome-icon icon="asterisk" />
      <span>Paciente</span>
    </b-dropdown-item>
    <b-dropdown-item to="/medico">
      <font-awesome-icon icon="asterisk" />
      <span>Medico</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
