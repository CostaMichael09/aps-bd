export interface IMedico {
  id?: number;
  nome?: string | null;
  especialidade?: string | null;
  crm?: number | null;
}

export class Medico implements IMedico {
  constructor(public id?: number, public nome?: string | null, public especialidade?: string | null, public crm?: number | null) {}
}
