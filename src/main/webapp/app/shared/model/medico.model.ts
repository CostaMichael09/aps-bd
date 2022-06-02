import { IExame } from '@/shared/model/exame.model';

export interface IMedico {
  id?: number;
  nome?: string | null;
  especialidade?: string | null;
  crm?: number | null;
  exames?: IExame[] | null;
}

export class Medico implements IMedico {
  constructor(
    public id?: number,
    public nome?: string | null,
    public especialidade?: string | null,
    public crm?: number | null,
    public exames?: IExame[] | null
  ) {}
}
