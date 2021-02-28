{{- define "microservice.namespace" -}}
{{- if .Values.namespace.create -}}
{{ include "common.name.value" . }}
{{- else -}}
{{ .Release.Namespace }}
{{- end }}
{{- end }}

{{- define "microservice.service.label" -}}
{{- if .Values.service.labels }}
{{- include "common.label.value" (dict "Values" .Values "Release" .Release "labels" .Values.service.labels) }}
{{- else }}
{{- include "microservice.label" (dict "Values" .Values "Release" .Release )}}
{{- end }}
{{- end }}

{{- define "microservice.label" -}}
{{- include "common.label.value" (dict "Values" .Values "Release" .Release "labels" .Values.labels) }}
{{- end }}