<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-8">
        <h1>Redefinir sua senha</h1>

        <div class="alert alert-warning" v-if="!success">
          <p>Digite o endereço de e-mail que você usou para se registrar .</p>
        </div>

        <div class="alert alert-success" v-if="success">
          <p>Verifique seus e-mails para obter detalhes sobre como redefinir sua senha .</p>
        </div>

        <form v-if="!success" name="form" role="form" v-on:submit.prevent="requestReset()">
          <div class="form-group">
            <label class="form-control-label" for="email">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              :class="{ valid: !$v.resetAccount.email.$invalid, invalid: $v.resetAccount.email.$invalid }"
              v-model="$v.resetAccount.email.$model"
              minlength="5"
              maxlength="254"
              email
              required
              data-cy="emailResetPassword"
            />
            <div v-if="$v.resetAccount.email.$anyDirty && $v.resetAccount.email.$invalid">
              <small class="form-text text-danger" v-if="!$v.resetAccount.email.required"> Seu e-mail é obrigatório . </small>
              <small class="form-text text-danger" v-if="!$v.resetAccount.email.email"> Seu email é invalido. </small>
              <small class="form-text text-danger" v-if="!$v.resetAccount.email.minLength">
                Seu e-mail deve ter pelo menos 5 caracteres.
              </small>
              <small class="form-text text-danger" v-if="!$v.resetAccount.email.maxLength">
                Seu e-mail não pode ter mais de 100 caracteres.
              </small>
            </div>
          </div>
          <button type="submit" :disabled="$v.resetAccount.$invalid" class="btn btn-primary" data-cy="submit">Reset</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reset-password-init.component.ts"></script>
