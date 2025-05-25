package com.example.usergems.util;

import com.example.usergems.model.response.Email;
import com.example.usergems.model.response.MeetingDetails;
import com.example.usergems.model.response.PersonMail;

public class EmailUtil {
    public static String renderEmail(Email email) {
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body style='font-family: Arial, sans-serif;'>");

        sb.append("<div style='text-align:center; margin-bottom:20px;'>")
                .append("<img src='https://usergems.com/logo.png' alt='UserGems Logo' style='height:40px;'>")
                .append("<h2 style='color:#00bfa5;'>Your Morning Update</h2>")
                .append("</div>");

        sb.append("<div style='border:1px solid #ccc; padding:20px; border-radius:10px;'>");

        sb.append("<p style='font-size:18px; font-weight:bold;'>")
                .append(email.start()).append(" - ").append(email.end())
                .append(" | <span style='color:#0077b5;'>").append(email.title()).append("</span>")
                .append(" ✅ <span style='font-size:14px;'>(30 min)</span></p>");

        sb.append("<p style='font-size:14px;'>Joining from UserGems: <strong>Joss ✅</strong></p>");



        for (PersonMail person : email.accepted()) {
            sb.append("<div style='margin-bottom:10px;'>")
                    .append("<img src='").append(person.getAvatar()).append("' width='32' style='vertical-align:middle; border-radius:50%; margin-right:8px;'>")
                    .append("<strong style='color:#0077b5;'>").append(person.getFullName()).append(" ✅</strong>")
                    .append("<br><span>").append(person.getTitle()).append("</span><br>")
                    .append("<span style='color:gray;'>")
                    .append(person.getTotalMeetingCount()).append("th Meeting");

            emptyCase(sb, person);
        }

        for (PersonMail person : email.rejected()) {
            sb.append("<div style='margin-bottom:10px;'>")
                    .append("<img src='").append(person.getAvatar()).append("' width='32' style='vertical-align:middle; border-radius:50%; margin-right:8px;'>")
                    .append("<strong style='color:#d32f2f;'>").append(person.getFullName()).append(" ❌</strong>")
                    .append("<br><span>").append(person.getTitle()).append("</span><br>")
                    .append("<span style='color:gray;'>")
                    .append(person.getTotalMeetingCount()).append("th Meeting");

            emptyCase(sb, person);
        }

        sb.append("</div></body></html>");
        return sb.toString();
    }

    private static void emptyCase(StringBuilder sb, PersonMail person) {
        if (person.getMeetingDetail() != null && !person.getMeetingDetail().isEmpty()) {
            sb.append(" | Met with ");
            for (int i = 0; i < person.getMeetingDetail().size(); i++) {
                MeetingDetails m = person.getMeetingDetail().get(i);
                sb.append(m.name()).append(" (").append(m.meetingCount()).append("x)");
                if (i < person.getMeetingDetail().size() - 1) sb.append(" & ");
            }
        }

        sb.append("</span></div>");
    }
}
