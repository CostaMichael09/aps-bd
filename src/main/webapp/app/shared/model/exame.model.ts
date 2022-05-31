export interface IExame {
  id?: number;
  tipo?: string | null;
  data?: Date | null;
  nomedomedico?: string | null;
}

export class Exame implements IExame {
  constructor(public id?: number, public tipo?: string | null, public data?: Date | null, public nomedomedico?: string | null) {}
}
