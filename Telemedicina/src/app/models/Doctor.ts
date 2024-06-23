import { Speciality } from "./Speciality";

export interface Doctor{
  id: number
  name: string;
  lastName: string;
  doctorDetails: string;
  email: string;
  dni: number;
  tuitionNumber: string;
  speciality: Speciality;
}
