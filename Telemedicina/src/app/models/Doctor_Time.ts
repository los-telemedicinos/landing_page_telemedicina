export interface Doctor_Time {
  id: number,
  day: string,
  startTime: string,
  endTime: string,
  usedAppointment: boolean,
  hidden?: boolean
}
