import {User} from './user';

export interface Destination {
  id?: number;
  name: string;
  description: string;
  country: string;
  provide: string;
  address: string;
  rating: number;
  likes: number;
  user: User;
}
