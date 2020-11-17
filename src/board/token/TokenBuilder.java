package board.token;

import java.util.ArrayList;
import java.util.List;

public class TokenBuilder {
    private List<Token> mTokens;

    public TokenBuilder() {
        mTokens = new ArrayList<>();
        initializeTokens();
    }


    public List<Token> getTokens() {
        return mTokens;
    }

    private void initializeTokens() {

        TokenType s = new TokenTypeS();
        mTokens = s.getTokens();
    }


}
