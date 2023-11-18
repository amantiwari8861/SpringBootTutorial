import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from "../models/user";
const USERS = [
    new User(1, 'admin', 'admin1234',"admin"),
    new User(2, 'manager', 'manager1234',"manager"),
    new User(3, 'employee', 'employee1234',"employee"),
    new User(4, 'user', 'user1234',"user")
];
const usersObservable = of(USERS);
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private isloggedIn = false;
    getAllUsers(): Observable<User[]> {
        return usersObservable;
    }
    isUserAuthenticated(username: string, password: string): Observable<boolean> {
        return this.getAllUsers().pipe(
            map(users => {
                const Authenticateduser = users.find(user => (user.username === username) && (user.password === password));
                if (Authenticateduser) {
                    this.isloggedIn = true;
                } else {
                    this.isloggedIn = false;
                }
                return this.isloggedIn;
            })
        );
    }
    isUserLoggedIn(): boolean {
        return this.isloggedIn;
    }
}
