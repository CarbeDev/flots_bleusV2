FROM node:18-alpine

WORKDIR ./app

COPY ./v2/package*.json ./

RUN npm install

COPY ./v2 ./
EXPOSE 3000

CMD ["npm","start"]
