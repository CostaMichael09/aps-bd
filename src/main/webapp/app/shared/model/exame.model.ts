import { IMedico } from '@/shared/model/medico.model';
import { IPaciente } from '@/shared/model/paciente.model';

export interface IExame {
  id?: number;
  tipo?: string | null;
  data?: Date | null;
  nomedomedico?: string | null;
  medico?: IMedico | null;
  paciente?: IPaciente | null;
}

export class Exame implements IExame {
  constructor(
    public id?: number,
    public tipo?: string | null,
    public data?: Date | null,
    public nomedomedico?: string | null,
    public medico?: IMedico | null,
    public paciente?: IPaciente | null
  ) {}
}
