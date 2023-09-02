package com.dresen.agePers.email;

public record EmailDetails(
        String from,
        String to,
        String subject,
        String body

) {

}
