<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-8 toastify-container">
        <h1 id="register-title" data-cy="registerTitle">Registrar</h1>

        <div class="alert alert-success" role="alert" v-if="success">
          <strong>Registro salvo!</strong> Por favor, check o email para confirmação.
        </div>

        <div class="alert alert-danger" role="alert" v-if="error"><strong>Registro falhou!</strong> Por favor, tente novamente.</div>

        <div class="alert alert-danger" role="alert" v-if="errorUserExists">
          <strong>Este nome já existe!</strong> Por favor escolha outro.
        </div>

        <div class="alert alert-danger" role="alert" v-if="errorEmailExists">
          <strong>Email já está em uso!</strong> Por favor escolha outro.
        </div>
      </div>
    </div>
    <div class="row justify-content-center">
      <div class="col-md-8">
        <form id="register-form" name="registerForm" role="form" v-on:submit.prevent="register()" v-if="!success" no-validate>
          <div class="form-group">
            <label class="form-control-label" for="username">Username</label>
            <input
              type="text"
              class="form-control"
              v-model="$v.registerAccount.login.$model"
              id="username"
              name="login"
              :class="{ valid: !$v.registerAccount.login.$invalid, invalid: $v.registerAccount.login.$invalid }"
              required
              minlength="1"
              maxlength="50"
              pattern="^[a-zA-Z0-9!#$&'*+=?^_`{|}~.-]+@?[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
              data-cy="username"
            />
            <div v-if="$v.registerAccount.login.$anyDirty && $v.registerAccount.login.$invalid">
              <small class="form-text text-danger" v-if="!$v.registerAccount.login.required"> Username é obrigatorio. </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.login.minLength">
                Username precisa de pelo menos 1 caracter.
              </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.login.maxLength">
                Username não pode ser maior que 50 caracteres.
              </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.login.pattern">
                Seu username pode conter letras e digitos.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="email">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              :class="{ valid: !$v.registerAccount.email.$invalid, invalid: $v.registerAccount.email.$invalid }"
              v-model="$v.registerAccount.email.$model"
              minlength="5"
              maxlength="254"
              email
              required
              data-cy="email"
            />
            <div v-if="$v.registerAccount.email.$anyDirty && $v.registerAccount.email.$invalid">
              <small class="form-text text-danger" v-if="!$v.registerAccount.email.required"> Email obrigatorio. </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.email.email"> Seu email é invalido. </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.email.minLength">
                Seu email precisa de pelo menos 5 caracteres.
              </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.email.maxLength">
                Seu email não pode passar de 100 caracteres.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="firstPassword">Nova senha</label>
            <input
              type="password"
              class="form-control"
              id="firstPassword"
              name="password"
              :class="{ valid: !$v.registerAccount.password.$invalid, invalid: $v.registerAccount.password.$invalid }"
              v-model="$v.registerAccount.password.$model"
              minlength="4"
              maxlength="50"
              required
              data-cy="firstPassword"
            />
            <div v-if="$v.registerAccount.password.$anyDirty && $v.registerAccount.password.$invalid">
              <small class="form-text text-danger" v-if="!$v.registerAccount.password.required"> Senha obrigatoria. </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.password.minLength">
                A senha não pode conter menos de 4 caracteres.
              </small>
              <small class="form-text text-danger" v-if="!$v.registerAccount.password.maxLength">
                Sua senha não pode ter mais de 50 caracteres.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="secondPassword">Confirmar senha</label>
            <input
              type="password"
              class="form-control"
              id="secondPassword"
              name="confirmPasswordInput"
              :class="{ valid: !$v.confirmPassword.$invalid, invalid: $v.confirmPassword.$invalid }"
              v-model="$v.confirmPassword.$model"
              minlength="4"
              maxlength="50"
              required
              data-cy="secondPassword"
            />
            <div v-if="$v.confirmPassword.$dirty && $v.confirmPassword.$invalid">
              <small class="form-text text-danger" v-if="!$v.confirmPassword.required"> Confirmação obrigatoria. </small>
              <small class="form-text text-danger" v-if="!$v.confirmPassword.sameAsPassword">
                Confirmação invalida!
              </small>
            </div>
          </div>

          <button type="submit" :disabled="$v.$invalid" class="btn btn-primary" data-cy="submit">Registrar!</button>
        </form>
        <p></p>
        <div class="alert alert-warning">
          <span>Vocẽ pode, </span>
          <a class="alert-link" v-on:click="openLogin()">entrar!</a
          ><span
            >, ou pode entrar com uma conta default:<br />- Administrador (login="admin" e senha="admin") <br />- Usuario (login="user" e
            senha="user").</span
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./register.component.ts"></script>
