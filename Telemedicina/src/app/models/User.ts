import { Authority } from "./Authority";

export interface User {
  id: number
  username: string
  password: string
  enable :boolean
  authorities: Authority[]
}
