// interface: get sign in user response body DTO //

import ResponseDto from '../response.dto';

export default interface GetSignInUserResponseDto extends ResponseDto {
    userId: string;
    name: string;
    profileImage: string | null;
    address: string;
    detailAddress: string | null;
    gender: string | null;
    age: number | null;
}
