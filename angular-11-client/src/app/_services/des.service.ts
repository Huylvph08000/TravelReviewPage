import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Destination} from '../interface/destination';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DestinationService{
  private readonly API_DESTINATION = 'http://localhost:8080/api/test/travelplaces';
  constructor(private httpClient: HttpClient) { }
  showDesList(): Observable<Destination[]>{
    return this.httpClient.get<Destination[]>(`${this.API_DESTINATION}`);
  }
  createDes(des: Destination): Observable<Destination>{
    return this.httpClient.post<Destination>(`${this.API_DESTINATION}`, des);
  }
}
