<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-8">
        <h1>Ativação</h1>
        <div class="alert alert-success" v-if="success">
          <span><strong>Seu usuario foi ativado.</strong> Por favor </span>
          <a class="alert-link" v-on:click="openLogin">Entre</a>.
        </div>
        <div class="alert alert-danger" v-if="error">
          <strong>Seu usuário não pôde ser ativado .</strong> Por favor, use o formulário de inscrição para se inscrever .
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./activate.component.ts"></script>
