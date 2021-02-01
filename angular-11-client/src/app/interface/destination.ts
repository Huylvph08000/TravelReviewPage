import {User} from './user';
import {Image} from './image';
export interface Destination {
  timeCreated: string;
  thumbnail: Image;
  file: any;
  id: number;
  name: string;
  shortDescription: string;
  description?: string;
  country: string;
  province: string;
  address: string;
  rate: number;
  like: number;
  user?: User;
}
