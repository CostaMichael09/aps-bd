<template>
  <div class="home row">
    <div class="col-md-3">
      <span class="hipster img-fluid rounded"></span>
    </div>
    <div class="col-md-9">
      <h1 class="display-4">Bem-vindo a nossa APS!</h1>
      <p class="lead">Aluno: Michael Costa / Matricula: 2018200580 - Aluno: Letícia Santos da Conceição / Matricula: 2017100186</p>
      <p class="lead">Aluno: Vinícius Lima / Matricula: 2018200264 - Aluno: Wenderson Campos Fernandes / Matricula: 2018102183</p>
      <p class="lead">Aluno: Anny Ferreira / Matricula: 2011201424</p>

      <div>
        <div class="alert alert-success" v-if="authenticated">
          <span v-if="username">Você está logado como "{{ username }}"</span>
        </div>

        <div class="alert alert-warning" v-if="!authenticated">
          <span>Você pode </span>
          <a class="alert-link" v-on:click="openLogin()">entrar</a
          ><span
            >, ou pode usar umas das contas default:<br />- Administrador (login="admin" e senha="admin") <br />- Usuario (login="user" e
            senha="user").</span
          >
        </div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span>Você não possui acesso?</span>&nbsp;
          <router-link class="alert-link" to="/register">Registre sua nova conta!</router-link>
        </div>
      </div>

      <p>Turma: 945 - DESENVOLVIMENTO DE APLICAÇÕES COM BANCO DE DADOS</p>
      <p>Professor: Marcelo Perantoni</p>

      <p>
        <span>Codigo completo está no</span>
        <a href="https://github.com/CostaMichael09/aps-bd" target="_blank" rel="noopener noreferrer">GitHub</a>!
      </p>
    </div>
  </div>
</template>

<script lang="ts" src="./home.component.ts"></script>
