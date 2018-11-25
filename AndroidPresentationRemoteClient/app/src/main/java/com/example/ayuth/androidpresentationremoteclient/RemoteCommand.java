package com.example.ayuth.androidpresentationremoteclient;

public enum RemoteCommand {
    START_PRESENTATION("startPresentation"),
    STOP_PRESENTATION("stopPresentation"),
    GOTO_FIRST_SLIDE("gotoFirstSlide"),
    GOTO_PREVIOUS_SLIDE("gotoPreviousSlide"),
    GOTO_NEXT_SLIDE("gotoNextSlide"),
    GOTO_LAST_SLIDE("gotoLastSlide");

    private final String text;

    /**
     * @param text
     */
    RemoteCommand(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
