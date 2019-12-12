package com.swiftcode.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class SearchUserDevicesException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public SearchUserDevicesException() {
        super(ErrorConstants.SEARCH_USER_DEVICES_TYPE, "Search user devices error", Status.BAD_REQUEST);
    }
}
