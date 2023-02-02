FROM node:18-alpine

COPY ./v2 .

RUN npm ci
RUN npm run build

CMD ["npx","serve","build"]
