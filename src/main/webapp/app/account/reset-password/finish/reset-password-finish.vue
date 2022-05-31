<template>
  <div>
    <div class="row justify-content-center">
      <div class="col-md-8">
        <h1>Redefinir sua senha</h1>

        <div class="alert alert-danger" v-if="keyMissing">
          <strong>A chave de redefinição de senha está ausente .</strong>
        </div>

        <div class="alert alert-danger" v-if="error">
          <p>Não foi possível redefinir sua senha. Lembre-se de que uma solicitação de senha é válida apenas por 24 horas.</p>
        </div>

        <div class="alert alert-success" v-if="success">
          <span><strong>Sua senha foi redefinida.</strong> Por favor </span>
          <a class="alert-link" v-on:click="openLogin">Entre</a>
        </div>
        <div class="alert alert-danger" v-if="doNotMatch">
          <p>A senha e sua confirmação não coincidem!</p>
        </div>

        <div class="alert alert-warning" v-if="!success && !keyMissing">
          <p>Escolha nova senha.</p>
        </div>

        <div v-if="!keyMissing">
          <form v-if="!success" name="form" role="form" v-on:submit.prevent="finishReset()">
            <div class="form-group">
              <label class="form-control-label" for="newPassword">Nova senha</label>
              <input
                type="password"
                class="form-control"
                id="newPassword"
                name="newPassword"
                :class="{ valid: !$v.resetAccount.newPassword.$invalid, invalid: $v.resetAccount.newPassword.$invalid }"
                v-model="$v.resetAccount.newPassword.$model"
                minlength="4"
                maxlength="50"
                required
                data-cy="resetPassword"
              />
              <div v-if="$v.resetAccount.newPassword.$anyDirty && $v.resetAccount.newPassword.$invalid">
                <small class="form-text text-danger" v-if="!$v.resetAccount.newPassword.required"> Senha obrigatoria. </small>
                <small class="form-text text-danger" v-if="!$v.resetAccount.newPassword.minLength">
                  Sua senha deve ter pelo menos 4 caracteres.
                </small>
                <small class="form-text text-danger" v-if="!$v.resetAccount.newPassword.maxLength">
                  Sua senha não pode ter mais de 50 caracteres.
                </small>
              </div>
            </div>
            <div class="form-group">
              <label class="form-control-label" for="confirmPassword">Nova senha confirmação</label>
              <input
                type="password"
                class="form-control"
                id="confirmPassword"
                name="confirmPassword"
                :class="{ valid: !$v.resetAccount.confirmPassword.$invalid, invalid: $v.resetAccount.confirmPassword.$invalid }"
                v-model="$v.resetAccount.confirmPassword.$model"
                minlength="4"
                maxlength="50"
                required
                data-cy="confirmResetPassword"
              />
              <div v-if="$v.resetAccount.confirmPassword.$anyDirty && $v.resetAccount.confirmPassword.$invalid">
                <small class="form-text text-danger" v-if="!$v.resetAccount.confirmPassword.sameAsPassword">
                  A senha e sua confirmação não coincidem!
                </small>
              </div>
            </div>
            <button type="submit" :disabled="$v.resetAccount.$invalid" class="btn btn-primary" data-cy="submit">Save</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reset-password-finish.component.ts"></script>
