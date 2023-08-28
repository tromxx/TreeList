package com.TreeListProject.TreeList.oauth;

import com.TreeListProject.TreeList.config.PrincipalDetails;
import com.TreeListProject.TreeList.constant.UserRole;
import com.TreeListProject.TreeList.entity.Member;
import com.TreeListProject.TreeList.reposiotry.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(userRequest);
    log.info("getAttributes : {}", oAuth2User.getAttributes());

    OAuth2UserInfo oAuth2UserInfo = null;

    String provider = userRequest.getClientRegistration().getRegistrationId();
/**   OAuth2UserRequest에서 provider 추출
      추출한 provider에 따라 각각 다른 방식으로 값 추출 후 User Entity로 변환
      google과 facebook과는 달리 kakao와 naver에서 받아온 정보는 객체 안에 객체가 있는 형식이라 추출할 때, 다른 처리 방식이 필요
      또한 kakao의 ID는 String 타입이 아닌 Long 타입이기 때문에 추출할 때, 다른 처리 방식이 필요함
 **/
    if(provider.equals("google")) {
      log.info("구글 로그인 요청");
      oAuth2UserInfo = new GoogleUserInfo( oAuth2User.getAttributes() );
    } else if(provider.equals("kakao")) {
      log.info("카카오 로그인 요청");
      oAuth2UserInfo = new KakaoUserInfo( (Map)oAuth2User.getAttributes() );
    } else if(provider.equals("naver")) {
      log.info("네이버 로그인 요청");
      oAuth2UserInfo = new NaverUserInfo( (Map)oAuth2User.getAttributes().get("response") );
    } else if(provider.equals("facebook")) {
      log.info("페이스북 로그인 요청");
      oAuth2UserInfo = new FacebookUserInfo( oAuth2User.getAttributes() );
    }

//    provider = "google", "kakao", "naver", "facebook"
//    providerId = google의 sub값, kakao와 facebook의 id값, naver의 response의 id 값
//    loginId = provider_providerId 로 설정
//    name = 각 사이트에 등록한 이름으로 설정
//    email = google과 facebook의 email값, kakao의 kakao_account의 email값, naver의 response의 email값
    String providerId = oAuth2UserInfo.getProviderId();
    String email = oAuth2UserInfo.getEmail();
    String loginId = provider + "_" + providerId;
    String name = oAuth2UserInfo.getName();

    Optional<Member> optionalUser = userRepository.findByLoginId(loginId);
    Member member = null;

    if(optionalUser.isEmpty()) {
      member = Member.builder()
              .loginId(loginId)
              .email(email)
              .name(name)
              .provider(provider)
              .providerId(providerId)
              .userRole(UserRole.USER)
              .build();
      userRepository.save(member);
    } else {
      member = optionalUser.get();
    }

    return new PrincipalDetails(member, oAuth2User.getAttributes());
  }
}

//        <google>
//        {
//          sub=103058387739722400130,
//          name=안창범,
//          given_name=창범,
//          family_name=안,
//          picture=https://lh3.googleusercontent.com/a/AEdFTp5SiCyTaOLog9sDPN6QhWwsUj7xPbfj4HQF0fdC=s96-c, email=chb20050@gmail.com,
//         email_verified=true,
//          locale=ko
//        }
//
//        <kakao>
//        {
//         id=2632890179,
//          connected_at=2023-01-22T08:17:54Z,
//         properties = {nickname=안창범},
//          kakao_account = {
//            profile_nickname_needs_agreement=false,
//            profile={nickname=안창범},
//            has_email=true,
//            email_needs_agreement=false,
//            is_email_valid=true,
//            is_email_verified=true,
//            email=chb2005@naver.com
//           }
//         }
//
//      <naver>
//      {
//        resultcode=00,
//        message=success,
//        response = {
//          id=pvdq1FSG3VZlD7Cp3JuWfAFi-3xir6A-WPlP5f8kXIo, email=chb20050@gmail.com,
//          name=안창범
//          }
//        }
//
//      <facebook>
//      {
//        id=5483543425087412,
//        name=안창범,
//        email=chb2005@naver.com
//      }