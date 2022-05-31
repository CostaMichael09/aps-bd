<template>
  <div class="home row">
    <div class="col-md-3">
      <span class="hipster img-fluid rounded"></span>
    </div>
    <div class="col-md-9">
      <h1 class="display-4">Bem-vindo a nossa APS!</h1>
      <p class="lead">Aluno: Michael Costa / Matricula: 2018200580</p>

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

      <p>Turma:</p>
      <p>Professor: Marcelo Perantoni</p>

<!--      <ul>-->
<!--        <li><a href="https://www.jhipster.tech/" target="_blank" rel="noopener noreferrer">JHipster homepage</a></li>-->
<!--        <li>-->
<!--          <a href="http://stackoverflow.com/tags/jhipster/info" target="_blank" rel="noopener noreferrer">JHipster on Stack Overflow</a>-->
<!--        </li>-->
<!--        <li>-->
<!--          <a href="https://github.com/jhipster/generator-jhipster/issues?state=open" target="_blank" rel="noopener noreferrer"-->
<!--            >JHipster bug tracker</a-->
<!--          >-->
<!--        </li>-->
<!--        <li>-->
<!--          <a href="https://gitter.im/jhipster/generator-jhipster" target="_blank" rel="noopener noreferrer">JHipster public chat room</a>-->
<!--        </li>-->
<!--        <li>-->
<!--          <a href="https://twitter.com/jhipster" target="_blank" rel="noopener noreferrer">follow @jhipster on Twitter</a>-->
<!--        </li>-->
<!--      </ul>-->

      <p>
        <span>Codigo completo está no</span>
        <a href="https://github.com/CostaMichael09/aps-bd" target="_blank" rel="noopener noreferrer">GitHub</a>!
      </p>
    </div>
  </div>
</template>

<script lang="ts" src="./home.component.ts"></script>
