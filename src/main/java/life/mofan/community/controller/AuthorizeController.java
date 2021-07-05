package life.mofan.community.controller;

import life.mofan.community.dto.AccessTokenDTO;
import life.mofan.community.dto.GithubUser;
import life.mofan.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 莫凡编程之路
 * @create 2021-07-01-17:51
 */
@Controller
public class AuthorizeController {

    private final GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    public AuthorizeController(GithubProvider githubProvider) {
        this.githubProvider = githubProvider;
    }

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")  String code,
                           @RequestParam(name="state") String state
    ){
            AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
            accessTokenDTO.setClient_id(clientId);
            accessTokenDTO.setClient_secret(clientSecret);
            accessTokenDTO.setCode(code);
            accessTokenDTO.setState(state);
            accessTokenDTO.setRedirect_uri(redirectUri);
            String accessToken = githubProvider.getAccessToken(accessTokenDTO);
            GithubUser user = githubProvider.getUser(accessToken);
            System.out.println(user.getName());
            return "index";
    }
}
