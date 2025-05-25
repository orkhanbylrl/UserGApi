package com.example.usergems.service;

import com.example.usergems.mapper.EmailMapper;
import com.example.usergems.model.dto.EmailDto;
import com.example.usergems.model.entity.EmailEntity;
import com.example.usergems.model.entity.UserEntity;
import com.example.usergems.model.response.Email;
import com.example.usergems.repository.EmailRepository;
import com.example.usergems.util.DateTimeUtils;
import com.example.usergems.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {
    UserService userService;
    MeetingService meetingService;
    EmailRepository emailRepo;

    @Scheduled(cron = "0 0 8 * * *")
    public void sendDailyEmails() {
        String customDate = "2022-06-27";
        sendEmail(customDate);
    }

    public void sendEmail(String customDate) {
        List<UserEntity> users = userService.getAll();

        for (UserEntity user : users) {
            List<Email> emails = meetingService.generateMeetingForUser(
                    user.getEmail(), user.getToken(), customDate
            );

            for (Email email : emails) {
                String content = EmailUtil.renderEmail(email);
                EmailDto emailDto = EmailDto.builder()
                        .recipient(user.getEmail())
                        .emailContentHtml(content)
                        .sentAt(DateTimeUtils.parseDateLocalDateTime(customDate))
                        .build();

                save(EmailMapper.INSTANCE.toEntity(emailDto));
            }
        }

    }


    public void save(EmailEntity email) {
        emailRepo.save(email);
    }

}
