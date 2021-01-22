import {User} from './user';

export interface Destination {
  datetime: number;
  img: string;
  id?: number;
  name: string;
  description: string;
  country: string;
  province: string;
  address: string;
  rate: number;
  like: number;
  user: User;
}
