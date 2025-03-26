import { Feeling, Weather } from 'src/types/aliases';

// interface: patch idary request body DTO //
export default interface PatchDiaryRequestDto {
    weather: Weather;
    feeling: Feeling;
    title: string;
    content: string;
}
