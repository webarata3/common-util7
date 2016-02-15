package link.arata.common.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {
    @Test
    public void isEmptyのnullの場合() {
        assertThat(StringUtil.isEmpty(null), is(true));
    }

    @Test
    public void isEmptyの空文字の場合() {
        assertThat(StringUtil.isEmpty(""), is(true));
    }

    @Test
    public void isEmptyのABCの場合() {
        assertThat(StringUtil.isEmpty("ABC"), is(false));
    }

    @Test
    public void isEmptyのあの場合() {
        assertThat(StringUtil.isEmpty("あ"), is(false));
    }

    @Test
    public void trimLeftの半角ブランクがtrimされること() {
        assertThat(StringUtil.trimLeft(" あいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeft全角ブランクがtrimされること() {
        assertThat(StringUtil.trimLeft("　あいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのタブがtrimされること() {
        assertThat(StringUtil.trimLeft("\tあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftの改行がtrimされること() {
        assertThat(StringUtil.trimLeft("\nあいうえお"), is("あいうえお"));
    }

    @Test
    public void trimLeftのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimLeft(" 　\t\nあいうえお"), is("あいうえお"));
    }

    public void trimLeftの右側がtrimされないこと() {
        assertThat(StringUtil.trimLeft("あいうえお\n\t　 "), is("あいうえお\n\t　 "));
    }

    public void trimLeftですべての文字がtrim対象の場合() {
        assertThat(StringUtil.trimLeft(" 　\t\n"), is(""));
    }

    public void trimLeftで空文字の場合() {
        assertThat(StringUtil.trimLeft(""), is(""));
    }

    @Test
    public void trimRightの半角ブランクがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお "), is("あいうえお"));
    }

    @Test
    public void trimRight全角ブランクがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお　"), is("あいうえお"));
    }

    @Test
    public void trimRightのタブがtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\t"), is("あいうえお"));
    }

    @Test
    public void trimRightの改行がtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお\n"), is("あいうえお"));
    }

    @Test
    public void trimRightのいろいろ混ざった場合にtrimされること() {
        assertThat(StringUtil.trimRight("あいうえお 　\t\n"), is("あいうえお"));
    }

    public void trimRightの左側がtrimされないこと() {
        assertThat(StringUtil.trimRight("\n\t　 あいうえお"), is("あいうえお\n\t　 "));
    }

    public void trimRightですべての文字がtrim対象の場合() {
        assertThat(StringUtil.trimRight(" 　\t\n"), is(""));
    }

    public void trimRightで空文字の場合() {
        assertThat(StringUtil.trimRight(""), is(""));
    }
}
