// index.ts가 아니라 dto.ts에 한번에 해도 상관없음.
// 경로가 깔끔한 장점.

import SignUpRequestDto from './sign-up.request.dto';
import SignInRequestDto from './sign-in.request.dto';
import IdCheckRequestDto from './id-check.request.dto';

export type { SignUpRequestDto, SignInRequestDto, IdCheckRequestDto };
