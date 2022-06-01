export interface IPaciente {
  id?: number;
  nome?: string | null;
  cpf?: number | null;
  telefone?: string | null;
}

export class Paciente implements IPaciente {
  constructor(public id?: number, public nome?: string | null, public cpf?: number | null, public telefone?: string | null) {}
}
