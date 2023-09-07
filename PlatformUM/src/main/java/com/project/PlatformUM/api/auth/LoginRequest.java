package com.project.PlatformUM.api.auth;

import lombok.AllArgsConstructor; // Code more cleanly, if i add new atribute i dont need to create get and set or modify the constructor
import lombok.Builder; //To build the object more easily
import lombok.Data;
import lombok.NoArgsConstructor; // Code more cleanly, if i add new atribute i dont need to create get and set or modify the constructor


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
    
}
