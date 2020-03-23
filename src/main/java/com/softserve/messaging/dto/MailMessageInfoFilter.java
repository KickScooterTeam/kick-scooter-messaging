package com.softserve.messaging.dto;

import com.softserve.messaging.model.EmailType;
import com.softserve.messaging.model.MailMessageInfo;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

@Data
public class MailMessageInfoFilter implements Specification<MailMessageInfo> {

    private String email;
    private EmailType emailType;

    @Override
    public Predicate toPredicate(Root<MailMessageInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (email != null && !email.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("email"), email));
        }
        if (emailType != null) {
            predicates.add(criteriaBuilder.equal(root.get("emailType"), emailType));
        }

        return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
