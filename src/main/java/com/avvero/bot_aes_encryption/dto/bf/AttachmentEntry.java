package com.avvero.bot_aes_encryption.dto.bf;

import lombok.Data;

import java.util.List;

/**
 * @author fxdev-belyaev-ay
 */
@Data
public class AttachmentEntry {

    private String title;
    private String subtitle;
    private String text;
    private List<Image> images;
    private List<Button> buttons;

}
