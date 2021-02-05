import {User} from './user';
import {Image} from './image';
import {Comment} from './comment';
export interface Destination {
  timeCreated: string;
  thumbnail: Image;
  comment: Comment;
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
